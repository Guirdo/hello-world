package tresde;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import org.scijava.java3d.BoundingSphere;
import org.scijava.java3d.BranchGroup;
import org.scijava.java3d.Canvas3D;
import org.scijava.java3d.DirectionalLight;
import org.scijava.java3d.Node;
import org.scijava.java3d.utils.geometry.Sphere;
import org.scijava.java3d.utils.universe.SimpleUniverse;
import org.scijava.vecmath.Color3f;
import org.scijava.vecmath.Point3d;
import org.scijava.vecmath.Vector3f;

public class Cubo extends Applet {

    public Cubo() throws HeadlessException {
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        add("Center", canvas3D);
        BranchGroup escena = crearEscenaGrafico();
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
        simpleU.getViewingPlatform().setNominalViewingTransform();
        simpleU.addBranchGraph(escena);
    }

    public BranchGroup crearEscenaGrafico() {
        BranchGroup objPrincipal = new BranchGroup();
        objPrincipal.addChild(CrearEsfera());
        objPrincipal.addChild(CrearIluminacion());
        return objPrincipal;
    }

    private Node CrearEsfera() {
        Sphere esfera = new Sphere(0.3f); //Tamaño esfera (0.3)
        return esfera;
    }

    private Node CrearIluminacion() {
        Color3f colorLuz = new Color3f(1.0f, 0.5f, 6.1f);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 20.0), 100.0);
        Vector3f direccionLuz = new Vector3f(4.0f, -7.0f, -12.0f);
        DirectionalLight luz1 = new DirectionalLight(colorLuz, direccionLuz);
        luz1.setInfluencingBounds(bounds);
        return luz1;
    }
    
}
