package com.ryliu.j2ee.hw01.chatroom;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
public class MySessionListener implements HttpSessionListener {

    /**
     * Default constructor.
     */
    public MySessionListener() {
        // empty
    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        ServletContext context = session.getServletContext();

        @SuppressWarnings("unchecked")
        Set<HttpSession> sessions = (Set<HttpSession>) context.getAttribute("sessions");
        if (sessions == null) {
            sessions = new HashSet<HttpSession>();
            context.setAttribute("sessions", sessions);
        }
        sessions.add(session);
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        ServletContext context = session.getServletContext();

        @SuppressWarnings("unchecked")
        Set<HttpSession> sessions = (Set<HttpSession>) context.getAttribute("sessions");
        sessions.remove(session);
    }

}
