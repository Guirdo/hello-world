package principal;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Ventana implements GLEventListener {

    @Override
    public void init(GLAutoDrawable glad) {
    }

    @Override
    public void dispose(GLAutoDrawable glad) {

    }

    @Override
    public void display(GLAutoDrawable glad) {
        final GL2 gl = glad.getGL().getGL2();

        gl.glBegin(GL2.GL_LINES);

        //drawing the base
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.50f, -0.59f, 0);
        gl.glVertex3f(0.55f,0.5f, 0);
        gl.glEnd();

    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

}
