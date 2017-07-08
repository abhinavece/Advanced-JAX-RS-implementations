package com.heapdev.restapi;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces("text/shortdate")
public class ShortdateMessageBodyWriter implements MessageBodyWriter<Date> {

	/**
	 * This method is deprecated sowe aare not implementing this one, instead we will return -1
	 */
	@Override
	public long getSize(Date arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type arg1, Annotation[] arg2, MediaType arg3) {
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(Date date, 
						Class<?> type, 
						Type type1, 
						Annotation[] annt, 
						MediaType mt,
						MultivaluedMap<String, Object> mvm, 
						OutputStream out) throws IOException, WebApplicationException {
		
		Calendar calendar = Calendar.getInstance();
		String shortdate = calendar.get(Calendar.DATE)+ "-"+ calendar.get(Calendar.MONTH)+ "-" + calendar.get(Calendar.YEAR);
		out.write(shortdate.getBytes());
	}

}
