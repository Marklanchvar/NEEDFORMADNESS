public class Utils
{

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
    
}
