package com.clarkparsia.pellet.server.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.complexible.pellet.service.Message;

/**
 * @author Edgar Rodriguez-Diaz
 */
public class MessageServlet extends HttpServlet {

	private static final String MESSAGE_PARAM = "message";

	private Message message;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		message = new Message(config.getInitParameter(MESSAGE_PARAM));
	}

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		PrintWriter writer = resp.getWriter();
		writer.write(message.toJsonString());
		writer.close();
	}

	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException,
	                                                                                           IOException {
		doGet(req, resp);
	}
}
