package com.salaodebeleza.estrutura.util.imagem;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import com.salaodebeleza.estrutura.util.Utils;

public class ImageFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		if(f.isDirectory()) {
			return true;
		}
		
		String extension = Utils.getExtension(f);
		if(extension!=null) {
			if(extension.equals(Utils.tiff) ||
			   extension.equals(Utils.tif) ||
			   extension.equals(Utils.gif) ||
			   extension.equals(Utils.jpeg)||
			   extension.equals(Utils.jpg) ||
			   extension.equals(Utils.png)) 
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
