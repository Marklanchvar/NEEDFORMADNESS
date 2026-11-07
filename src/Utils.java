public class Utils
{
	Medium m;
	
	public static int clamp255(int value) {
	    return value > 255 ? 255 : (value < 0 ? 0 : value);
	}

    public static float cos(float i) {
        while (i >= 360) {
            i -= 360;
        }
        while (i < 0) {
            i += 360;
        }
        return (float) Math.cos(Math.toRadians(i));
    }
    
    public static float sin(float f) {
        while (f >= 360) {
            f -= 360;
        }
        while (f < 0) {
            f += 360;
        }
        return (float) Math.sin(Math.toRadians(f));
    }
    
    public static float acos(float i) {
    	while (i > 1F) {
            i = 1F;
        }
        while (i < -1F) {
            i = -1F;
        }
        return (float) Math.toDegrees(Math.acos(i));
    }
    
    public static float asin(float f) {
        while (f > 1F) {
            f = 1F;
        }
        while (f < -1F) {
            f = -1F;
        }
        return (float) Math.toDegrees(Math.asin(f));
    }
    
    public static int xs(final float f, float n5) {
        if (n5 < Medium.cz) {
            n5 = Medium.cz;
        }
        return (int) ((n5 - Medium.focus_point) * (Medium.cx - f) / n5 + f);
    }
    
    public static int ys(final float n, float n2) {
        if (n2 < Medium.cz) {
            n2 = Medium.cz;
        }
        return (int) ((n2 - Medium.focus_point) * (Medium.cy - n) / n2 + n);
    }
    
    public static void rot(final float[] pointX, final float[] pointY, final float originX, final float originY, final float angle, final int count) {
        if (angle != 0) {
            for (int i = 0; i < count; ++i) {
                final float cloneX = pointX[i];
                final float cloneY = pointY[i];
                pointX[i] = originX + ((cloneX - originX) * Utils.cos(angle) - (cloneY - originY) * Utils.sin(angle));
                pointY[i] = originY + ((cloneX - originX) * Utils.sin(angle) + (cloneY - originY) * Utils.cos(angle));
            }
        }
    }
    
    public static void rot(final int[] pointX, final int[] pointY, final float originX, final float originY, final float angle, final int count) {
        if (angle != 0) {
            for (int i = 0; i < count; ++i) {
                final int cloneX = pointX[i];
                final int cloneY = pointY[i];
                pointX[i] = (int) (originX + ((cloneX - originX) * Utils.cos(angle) - (cloneY - originY) * Utils.sin(angle)));
                pointY[i] = (int) (originY + ((cloneX - originX) * Utils.sin(angle) + (cloneY - originY) * Utils.cos(angle)));
            }
        }
    }
    
    public static void rot(float pointX, float pointY, final float originX, final float originY, final float angle) {
        if (angle != 0) {
                final float cloneX = pointX;
                final float cloneY = pointY;
                pointX = originX + ((cloneX - originX) * Utils.cos(angle) - (cloneY - originY) * Utils.sin(angle));
                pointY = originY + ((cloneX - originX) * Utils.sin(angle) + (cloneY - originY) * Utils.cos(angle));
        }
    }
    
}
