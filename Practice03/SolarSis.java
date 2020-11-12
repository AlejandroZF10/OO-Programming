import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class SolarSis {
public SolarSis(){
	BranchGroup group = new BranchGroup();
	Appearance appsol = new Appearance();
	Appearance appearth = new Appearance();
	Appearance appvenus = new Appearance();
	Appearance appneptuno = new Appearance();

  	TextureLoader tex=new TextureLoader("TIERRA.JPG", null);
	appearth.setTexture(tex.getTexture());
	tex=new TextureLoader("SOL.JPG", null);
	appsol.setTexture(tex.getTexture());
	tex=new TextureLoader("VENUS.JPG", null);
	appvenus.setTexture(tex.getTexture());
	tex=new TextureLoader("NEPTUNO.JPG", null);
	appneptuno.setTexture(tex.getTexture());

	Sphere earth = new Sphere(0.045f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appearth);
	Sphere sol = new Sphere(0.35f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appsol);
	Sphere venus = new Sphere(0.035f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appvenus);
	Sphere neptuno = new Sphere(0.15f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appneptuno);

	TransformGroup earthRotXformGroup = Posi.rotate(earth, new Alpha(-1, 1250));
	TransformGroup solRotXformGroup = Posi.rotate(sol, new Alpha(-1, 1250));
	TransformGroup venusRotXformGroup = Posi.rotate(venus, new Alpha(-3, 1250));
	TransformGroup neptunoRotXformGroup = Posi.rotate(neptuno, new Alpha(-2, 1250));

	TransformGroup earthTransXformGroup = Posi.translate(earthRotXformGroup,new Vector3f(0.0f, 0.0f, 0.7f));
	TransformGroup venusTransXformGroup = Posi.translate(venusRotXformGroup, new Vector3f(0.0f, 0.0f, 0.5f));
	TransformGroup neptunoTransXformGroup = Posi.translate(neptunoRotXformGroup, new Vector3f(0.0f, 0.0f, 0.9f));

	TransformGroup earthRotGroupXformGroup = Posi.rotate(earthTransXformGroup, new Alpha(-1, 3000));
	TransformGroup venusRotGroupXformGroup = Posi.rotate(venusTransXformGroup, new Alpha(-1, 2000));
	TransformGroup neptunoRotGroupXformGroup = Posi.rotate(neptunoTransXformGroup, new Alpha(-1, 6000));

    	group.addChild(earthRotGroupXformGroup);
    	group.addChild(solRotXformGroup);
			group.addChild(venusRotGroupXformGroup);
			group.addChild(neptunoRotGroupXformGroup);

    	GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    	Canvas3D canvas = new Canvas3D(config); canvas.setSize(1000, 600);
    	SimpleUniverse universe = new SimpleUniverse(canvas);
    	universe.getViewingPlatform().setNominalViewingTransform();
    	universe.addBranchGraph(group);
    	JFrame f = new JFrame("Planetario");
    	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	f.add(canvas); f.pack(); f.setVisible(true); }
public static void main(String a[]) { new SolarSis();}
}
