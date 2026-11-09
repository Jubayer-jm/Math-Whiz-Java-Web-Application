package controller;

import dao.ScoreDAO;
import model.GameRound;
import model.GameScore;
import service.MathService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    private static final String DIFFICULTY = "NORMAL";
    private final ScoreDAO dao = new ScoreDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("leaderboard".equals(req.getParameter("action"))) {
            showLeaderboard(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("start".equals(action)) {
            startGame(req, resp);
        } else if ("submit".equals(action)) {
            submitAnswers(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    private void startGame(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("playerName");
        name = name == null ? "" : name.trim();
        if (name.isEmpty() || name.length() > 100) {
            req.setAttribute("error", "Please enter a player name (1-100 characters).");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("playerName", name);
        session.setAttribute("round", new GameRound());
        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }

    private void submitAnswers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        GameRound round = session == null ? null : (GameRound) session.getAttribute("round");
        String name = session == null ? null : (String) session.getAttribute("playerName");
        if (round == null || name == null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        int primeAns, modAns;
        double trig1Ans, trig2Ans;
        try {
            primeAns = Integer.parseInt(req.getParameter("primeAnswer").trim());
            if (primeAns != 0 && primeAns != 1) {
                throw new IllegalArgumentException("Q1 answer must be 1 (prime) or 0 (not prime).");
            }
            modAns = Integer.parseInt(req.getParameter("modAnswer").trim());
            trig1Ans = Double.parseDouble(req.getParameter("trig1Answer").trim());
            trig2Ans = Double.parseDouble(req.getParameter("trig2Answer").trim());
        } catch (NumberFormatException | NullPointerException e) {
            req.setAttribute("error", "Please enter valid numbers in all answer fields (Q1 and Q2 must be integers).");
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
            return;
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
            return;
        }

        // Answers are calculated here using Java methods
        int expectedPrime = MathService.isPrime(round.getPrimeNumber());
        int expectedMod;
        try {
            expectedMod = MathService.calculateMod(round.getModA(), round.getModB());
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
            return;
        }
        double expectedTrig1 = MathService.calculateTrig(round.getTrig1Func(), round.getTrig1Angle());
        double expectedTrig2 = MathService.calculateTrig(round.getTrig2Func(), round.getTrig2Angle());

        boolean primeCorrect = primeAns == expectedPrime;
        boolean modCorrect = modAns == expectedMod;
        boolean trig1Correct = MathService.isClose(expectedTrig1, trig1Ans);
        boolean trig2Correct = MathService.isClose(expectedTrig2, trig2Ans);
        int total = MathService.calculateScore(primeCorrect, modCorrect, trig1Correct, trig2Correct);

        try {
            dao.save(new GameScore(name, total, DIFFICULTY));
        } catch (SQLException e) {
            log("Could not save score", e);
            req.setAttribute("dbError", "Score could not be saved to the database: " + e.getMessage());
        }

        req.setAttribute("playerName", name);
        req.setAttribute("score", total);
        req.setAttribute("difficulty", DIFFICULTY);
        req.setAttribute("round", round);
        req.setAttribute("expectedPrime", expectedPrime);
        req.setAttribute("expectedMod", expectedMod);
        req.setAttribute("expectedTrig1", String.format("%.4f", expectedTrig1));
        req.setAttribute("expectedTrig2", String.format("%.4f", expectedTrig2));
        req.setAttribute("primeCorrect", primeCorrect);
        req.setAttribute("modCorrect", modCorrect);
        req.setAttribute("trig1Correct", trig1Correct);
        req.setAttribute("trig2Correct", trig2Correct);

        session.removeAttribute("round"); // prevents double submission
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

    private void showLeaderboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("scores", dao.getTop10());
        } catch (SQLException e) {
            log("Could not load leaderboard", e);
            req.setAttribute("dbError", "Could not load leaderboard: " + e.getMessage());
        }
        req.getRequestDispatcher("/leaderboard.jsp").forward(req, resp);
    }
}
