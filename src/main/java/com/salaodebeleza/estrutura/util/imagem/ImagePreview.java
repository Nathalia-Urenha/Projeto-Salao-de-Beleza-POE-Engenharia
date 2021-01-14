package com.salaodebeleza.estrutura.util.imagem;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

public class ImagePreview extends JComponent implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7060798214188014053L;
	
	ImageIcon thumbnail = null;
	File file = null;
	
	public ImagePreview(JFileChooser fc) {
		setPreferredSize(new Dimension(100,50));
		fc.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		boolean update = false;
		
		String prop = evt.getPropertyName();
		
		if(JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(prop)) {
			file = null;
			update = true;
		}
		else if(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(prop)) {
			file = (File) evt.getNewValue();
			update = true;
		}
		
		if(update) {
			thumbnail = null;
			if(isShowing()) {
				loadImage();
				repaint();
			}
		}
		
	}

	private void loadImage() {
		
		if(file == null) {
			thumbnail = null;
			return;
		}
		
		ImageIcon tmpIcon = new ImageIcon(file.getPath());
		if(tmpIcon != null) {
			if(tmpIcon.getIconWidth() > 90 ) {
				thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(90, -1, Image.SCALE_DEFAULT));
			}else {
				thumbnail = tmpIcon;
			}
		}
		
	}
	
	protected void paintComponent(Graphics g) {
		
		if(thumbnail == null) {
			loadImage();
		}
		
		if(thumbnail !=null) {
			int x = getWidth()/2 - thumbnail.getIconWidth()/2;
			int y = getHeight()/2 - thumbnail.getIconHeight()/2;
			
			if(y<0) {
				y=0;
			}
			
			if(x>5) {
				x=5;
			}
			
			thumbnail.paintIcon(this, g, x, y);
			
		}
	}

}
