package manytomany.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import manytomany.model.City;
import manytomany.model.Human;
import manytomany.store.HbmStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author ArvikV
 * @version 1.0
 * @since 16.01.2022
 */
@WebServlet(urlPatterns = "/humans")
public class HumanServlet extends HttpServlet {
    private final static Gson GSON = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<City> cities = HbmStore.instanceOf().allCities();
        req.setAttribute("allCities", cities);
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] cIds = req.getParameterValues("cIds");
        String info = req.getParameter("info");
        Human human = Human.of(info);
        HbmStore.instanceOf().addNewHuman(human, cIds);
        resp.sendRedirect(req.getContextPath() + "/humans");
    }
}
