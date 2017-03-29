package com.braceletService.MessageWriter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.braceletService.exception.ValidationException;
import com.braceletService.model.Bracelet;

@Provider
@Consumes("application/xml")
public class BraceletMessageBodyWriter implements MessageBodyReader<Bracelet> {

    @Context
    protected Providers providers;
    
    private Schema schema;
    
	@Override
	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		return arg0 == Bracelet.class;
	}

	@Override
	public Bracelet readFrom(Class<Bracelet> arg0, Type arg1, Annotation[] arg2, MediaType arg3,
			MultivaluedMap<String, String> arg4, InputStream arg5) throws IOException, WebApplicationException {
	    try {
	            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            URL schemaFile = BraceletMessageBodyWriter.class.getResource("Bracelet.xsd"); 
	            schema = sf.newSchema(schemaFile);
	            JAXBContext jaxbContext = null;
	            ContextResolver<JAXBContext> resolver = providers.getContextResolver(JAXBContext.class, arg3);
	            if(null != resolver) {
	                jaxbContext = resolver.getContext(arg0);
	            }
	            if(null == jaxbContext) {
	                jaxbContext = JAXBContext.newInstance(arg0);
	            }
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            unmarshaller.setSchema(schema);
	            return (Bracelet) unmarshaller.unmarshal(arg5);
	        } catch(JAXBException e) {
	        	String message = e.toString().substring(e.toString().lastIndexOf(':')+1, e.toString().lastIndexOf(']')).trim();
	        	if(message.indexOf(';') > -1){ 
	        		message = message.substring(message.indexOf(';')+1).trim(); 
	        	}
	            throw new ValidationException(new JAXBException(message));
	        }catch(Exception e) {
	            throw new RuntimeException(e);
	        }

	}

}
