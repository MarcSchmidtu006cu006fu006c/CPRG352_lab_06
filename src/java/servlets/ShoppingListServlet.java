/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 854638
 */
public class ShoppingListServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String par = request.getParameter("acts");
        String user = (String) request.getSession().getAttribute("userName");
        if (par != null && par.equals("logout")){
            request.getSession().invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        if(user != null){
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;
        }
        if(user == null || user.isEmpty()){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList itemList = (ArrayList) request.getSession().getAttribute("items");
        String selection = request.getParameter("acts");
        System.out.println("this is the selection: " + selection);
        if(selection.equals("add") || selection == "add"){
            if(itemList == null){
            itemList = new ArrayList<>();
            }
            String item = request.getParameter("item");
            itemList.add(item);
            request.getSession().setAttribute("items", itemList);
            request.getSession().setAttribute("item", item);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;
        }
        if(selection.equals("del") || selection == "del"){
            System.out.println("print at line 61");
            String badItem = request.getParameter("item");
            itemList.remove(badItem);
            request.getSession().setAttribute("items", itemList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;
        }
        if (selection.equals("reg")){
            String user = request.getParameter("userName");
            request.getSession().setAttribute("userName", user);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;
        }
        
        
        
        
        
    }

    

}
