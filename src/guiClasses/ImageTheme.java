package guiClasses;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

/**
 * Represents a theme for the images in the game.
 * @author Ian Dewan
 *
 */
public class ImageTheme {
	private static Map<String, ImageTheme> themes =
		new HashMap<String, ImageTheme>();
	private Map<ImageUse, ImageIcon> icons = new HashMap<ImageUse, ImageIcon>();
	
	/**
	 * Creates a new theme. Did I really have to explain that?
	 * @param src The directory to get the images from.
	 */
	protected ImageTheme(String src) {
		for (ImageUse i: ImageUse.values()) {
			icons.put(i, new ImageIcon(src + "/" + i.getFile() + ".png"));
		}
	}
	
	public ImageIcon getImage(ImageUse use) {
		return icons.get(use);
	}
	
	public static ImageTheme getThemeByName(String name) {
		if (themes.containsKey(name)) {
			return themes.get(name);
		} else {
			ImageTheme tmp = new ImageTheme("pictures/" + name);
			themes.put(name, tmp);
			return tmp;
		}
	}
	
	public static ImageTheme getDefaultTheme() {
		return getThemeByName("original");
	}
	
	/**
	 * This enumerated type represents an individual image that appears in a theme.
	 * @author Ian Dewan
	 *
	 */
	public static enum ImageUse {
		/** A pushable thing. */
		BOULDER ("obj1"),
		/** An un-pushable thing*/
		WALL ("obj2"),
		/** The player */
		PLAYER ("obj3"),
		/** An area that can be walked over */
		EMPTY ("obj4"),
		/** A square you must step on to win */
		EXIT ("obj5"),
		/** Swallows up boulders (kills player?) */
		HOLE ("obj6");
		/*
		 * Add new images like this:
		 * INTERNAL_NAME ("image_file_name")
		 */
		
		private final String file;
		
		ImageUse (String file) {
			this.file = file;
		}
		
		/**
		 * Return the filename associated with the image type.
		 * @return The filename, minus extension
		 */
		String getFile() {
			return file;
		}
	}

}