package com.hochschild.insumoQuimico.BaseController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.domain.Usuario;

public abstract class BaseReporteController {
	
	public Usuario usuario;
	protected boolean mostrarBotonTxt= true;
	
	@RequestMapping(value = "/verReporte.htm")
	public String verReporte(HttpSession sesion, HttpServletRequest req, Model model) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		this.usuario = usuarioSession;
		model.addAttribute("mostrarBotonTxt", this.mostrarBotonTxt);
		model = this.setViewAttributes(model);
		return this.getPaginaReporte();
	}
	
	public byte[] convertArrayByte(InputStream is) throws IOException{
		int size = 1024;
		int len = 0;
		byte[] data = new byte[size];

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = is.read(data, 0, size)) != -1) {
			bos.write(data, 0, len);
		}

		return bos.toByteArray();
	}
	
	public void descargarArchivoTxt(HttpServletResponse response, String nombreArchivo, String cadenaData){
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition","attachment; filename=" + nombreArchivo+".txt");

		ServletOutputStream out;
		try {
			out = response.getOutputStream();
			InputStream inputStream = new ByteArrayInputStream(cadenaData.getBytes(Charset.forName("UTF-8")));

			IOUtils.write(convertArrayByte(inputStream), out);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public abstract String getPaginaReporte();
	
	public abstract Model setViewAttributes(Model model);

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
