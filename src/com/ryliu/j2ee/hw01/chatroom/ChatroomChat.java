package com.ryliu.j2ee.hw01.chatroom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatroomChat
 */
public class ChatroomChat extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatroomChat() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // get parameters
        String username = request.getParameter("username");
        String text = request.getParameter("text");

        // add message
        addMessage(username + ": " + text);

        // send redirect
        response.sendRedirect("chatroom.jsp");
    }

    /**
     * Add message to servlet context.
     *
     * @param message
     *            the message
     */
    @SuppressWarnings("unchecked")
    private void addMessage(String message) {
        List<String> messages = (List<String>) getServletContext().getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList<String>();
        }
        messages.add(message);
        getServletContext().setAttribute("messages", messages);
    }

}
