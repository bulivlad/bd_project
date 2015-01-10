package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.CarsControllerImpl;
import ro.autoDealerSales.web.domain.CarFeature;
import ro.autoDealerSales.web.domain.CarForSale;
import ro.autoDealerSales.web.utils.DBOperations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Buli on 1/4/2015.
 */

@WebServlet(name = "CarsServlet", urlPatterns = "/cars")
public class CarsServlet extends HttpServlet {

    ServletContext context;
    CarForSale carForSale;
    CarFeature carFeature;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        CarsControllerImpl carsController = new CarsControllerImpl();

        if(action.equals("viewAll")){
            ArrayList<CarForSale> carsForSale = carsController.getAllCarsForSale();

            req.setAttribute("carsForSale",carsForSale);

            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/carsgeneralinfo.jsp");
            requestDispatcher.include(req,resp);
        }
        else
            if(action.equals("addOne")){

                RequestDispatcher requestDispatcher = context.getRequestDispatcher("/addcar.jsp");
                requestDispatcher.include(req,resp);

            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        CarsControllerImpl carsController = new CarsControllerImpl();

        if(action.equals("viewOne")){
            String id = req.getParameter("id");
            carForSale = carsController.getCarForSaleById(id);
            carFeature = carsController.getCarFeatureByCarForSaleId(id);

            req.setAttribute("carForSale",carForSale);
            req.setAttribute("carFeatures", carFeature);

            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/carsallinfo.jsp");
            requestDispatcher.include(req,resp);
        }
        else{
            if(action.equals("editOne")){
                String id = req.getParameter("id");
                String update = req.getParameter("update");

                if(update.equals("no")) {
                    carForSale = carsController.getCarForSaleById(id);
                    carFeature = carsController.getCarFeatureByCarForSaleId(id);

                    setRequestAtributes(req);

                    RequestDispatcher requestDispatcher = context.getRequestDispatcher("/editcar.jsp");
                    requestDispatcher.include(req, resp);
                }
                else{
                    String marca,model,categorie,pret,km,anFabricatie,dotari;

                    marca = req.getParameter("ManufacturerName");
                    model = req.getParameter("ModelName");
                    categorie =  req.getParameter("VehicleCategory");
                    pret =  req.getParameter("AskingPrice");
                    km =  req.getParameter("CurrentMileage");
                    anFabricatie =  req.getParameter("date_acquired");
                    dotari = req.getParameter("description");

                    ArrayList<String> sqlStrings = new ArrayList<String>();

                    sqlStrings.add("UPDATE car_features set car_feature_description='"+ dotari + "' where car_feature_id= "+ carFeature.getId());
                    sqlStrings.add("UPDATE cars_for_sale set manufacturer_name='"+ marca +"',model_name='"+ model +"',vehicle_category='"+ categorie +"',asking_price="+ pret +",current_mileage="+ km +",date_acquired=TO_DATE('"+ anFabricatie +"','yyyy-MM-dd'), car_features_id=" + carFeature.getId() + " where  car_for_sale_id="+ carForSale.getId());

                    Integer result = DBOperations.update(sqlStrings);

                    context.setAttribute("sqlResult", result);

                    resp.sendRedirect("cars?action=viewAll");
                }
            }
            else{
                if(action.equals("deleteOne")){
                    ArrayList<String> sqlStrings = new ArrayList<String>();

                    sqlStrings.add("DELETE from customer_payments where car_sold_id= (select car_sold_id from cars_sold where car_for_sale_id=" + carForSale.getId() +")");
                    sqlStrings.add("DELETE from cars_sold where car_for_sale_id ="+ carForSale.getId());
                    sqlStrings.add("DELETE from cars_for_sale where car_for_sale_id ="+ carForSale.getId());
                    sqlStrings.add("DELETE from car_features where car_feature_id =" + carFeature.getId());

                    int result = DBOperations.delete(sqlStrings);

                    context.setAttribute("sqlResult",result);

                    resp.sendRedirect("cars?action=viewAll");

                }
                else{
                    if(action.equals("addOne")){
                        ArrayList<String> sqlStrings = new ArrayList<String>();

                        String marca,model,categorie,pret,km,anFabricatie,dotari;

                        marca = req.getParameter("marca");
                        model = req.getParameter("model");
                        categorie =  req.getParameter("categorie");
                        pret =  req.getParameter("pret") != null ? req.getParameter("pret") : "";
                        km =  req.getParameter("km") != null ? req.getParameter("km") : "";
                        anFabricatie =  req.getParameter("an") != null ? req.getParameter("an") : "";
                        dotari = req.getParameter("dotari") != null ? req.getParameter("dotari") : "";

                        sqlStrings.add("INSERT INTO car_features (car_feature_id, car_feature_description) values ( features_increment.nextval, '" + dotari +"')");
                        sqlStrings.add("INSERT INTO cars_for_sale (car_for_sale_id,manufacturer_name,model_name,vehicle_category,asking_price,current_mileage,date_acquired, car_features_id) values ( sale_increment.nextval, '" + marca + "', '" + model + "', '" + categorie  + "', " + pret + ", " + km + ", TO_DATE('" + anFabricatie + "','yyyy-MM-dd'), (select max(car_feature_id) from car_features))");

                        int result = carsController.addInfoIntoDB(sqlStrings);

                        context.setAttribute("sqlResult",result);

                        resp.sendRedirect("cars?action=viewAll");
                    }
                }
            }
        }
    }

    private void setRequestAtributes(HttpServletRequest req) {
        req.setAttribute("carForSale",carForSale);
        req.setAttribute("carFeatures", carFeature);
    }
}
