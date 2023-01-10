package org.solution.kotenko;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.solution.kotenko.data.DataStorage;
import org.solution.kotenko.model.Fibonacci;
import org.solution.kotenko.utils.Utils;

import java.io.IOException;

/**
 * Represents API with GET an POST methods
 */
public class MyServlet extends HttpServlet {
    /**
     * Provide GET methods of current API
     *
     * @param req  takes request
     * @param resp takes response
     * @throws ServletException exception
     * @throws IOException exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Enter param to URI, example: /main?num=1,1,2,3" + "\n");

        String num = req.getParameter("num");
        Fibonacci fibonacci = new Fibonacci(num);
        if (Utils.isFibonacci(fibonacci.getNum())) {
            resp.getWriter().write("your num is really fibonacci and reversed" + "\n");
            resp.getWriter().write(Utils.reverseSequence(fibonacci.getNum()));
        } else {
            resp.getWriter().write("your num isn't really fibonacci and didn't reverse" + "\n");
            resp.getWriter().write(fibonacci.getNum());
        }
    }

    /**
     * Provide POST methods of current API
     *
     * @param req  takes request
     * @param resp takes response
     * @throws ServletException exception
     * @throws IOException exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");
        DataStorage.getInstance().setFibonacci(new Fibonacci(num));
    }
}