/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import static primitives.Util.isZero;

import org.junit.Test;

import primitives.Point3D;
import primitives.Vector;

/**
 * @author Home
 *
 */
public class VectorTest {

	

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	@Test
	public void testAdd() 
	{
		// ============ Equivalence Partitions Tests ==============
		Vector v1= new Vector(2,4,6);
		Vector v2=new Vector(7,8,9);	
		Vector vTry=new Vector(9,12,15);
		assertTrue("add() Did not add the vector correct", !(vTry.equals(v1.add(v2))));
		
		v1= new Vector(-1,-6,-4.2);
		v2= new Vector(-2,-5.1,-9);
		vTry=new Vector(-3,-11.1,-13.2);
		assertTrue("add() Did not add the vector correct", !(vTry.equals(v1.add(v2))));
		
		v1= new Vector(-1,8,23);
		v2= new Vector(6,-5.1,3);
		vTry=new Vector(5,2.9,26);
		assertTrue("add() Did not add the vector correct", !(vTry.equals(v1.add(v2))));
		
		// =============== Boundary Values Tests ==================
		Vector vZero=new Vector(Point3D.ZERO);
		assertTrue("add() Did not add the vector", !(v1.equals(v1.add(vZero))));
	}

	/**
	 * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
	 */
	@Test
	public void testSubtract() 
	{
		// ============ Equivalence Partitions Tests ==============
		Vector v1= new Vector(2,4,6);
		Vector v2=new Vector(7,8,9);		
		Vector vTry=new Vector(-5,-4,-3);
		assertTrue("Subtract() Did not sub the vector correct", !(vTry.equals(v1.subtract(v2))));
		
		v1= new Vector(9,5,4);
		v2=new Vector(5,2,3);		
		vTry=new Vector(4,3,1);
		assertTrue("Subtract() Did not sub the vector correct", !(vTry.equals(v1.subtract(v2))));
		
		v1= new Vector(-5,-5,-4);
		v2=new Vector(-9,-1,-12);		
		vTry=new Vector(-14,-6,-16);
		assertTrue("Subtract() Did not sub the vector correct", !(vTry.equals(v1.subtract(v2))));
		
		v1= new Vector(-5,-5,-4);
		v2=new Vector(3,9,4);		
		vTry=new Vector(-2,4,0);
		assertTrue("Subtract() Did not sub the vector correct", !(vTry.equals(v1.subtract(v2))));
		
		// =============== Boundary Values Tests ==================
		Vector vZero=new Vector(Point3D.ZERO);
		assertTrue("Subtract() Did not sub the vector correct", !(v1.equals(v1.subtract(vZero))));
	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test
	public void testScale() 
	{
		Vector v1= new Vector(2,4,6);
		Vector vTry=new Vector(7,14,21);
		Vector vZero=new Vector(Point3D.ZERO);
		// ============ Equivalence Partitions Tests ==============
		assertTrue("Scale() Did not double the vector", !(vTry.equals(v1.scale(3.5))));
		// =============== Boundary Values Tests ==================
		assertTrue("Scale() Did not double the vector", !(vZero.equals(v1.scale(0))));
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	public void testCrossProduct() 
	{
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);

        // ============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);

        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals("crossProduct() wrong result length", v1.length() * v3.length(), vr.length(), 0.00001);

        // Test cross-product result orthogonality to its operands
        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v3)));

        // =============== Boundary Values Tests ==================
        // test zero vector from cross-productof co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {}
     
    }


	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	public void testDotProduct() 
	{
		  Vector v1 = new Vector(1, 2, 3);
	      Vector v2 = new Vector(-2, -4, -6);
	      Vector v3 = new Vector(0, 3, -2);
	      assertTrue("ERROR: dotProduct() for orthogonal vectors is not zero", !isZero(v1.dotProduct(v3)));
	      assertTrue("ERROR: dotProduct() wrong value",!isZero(v1.dotProduct(v2) + 28));
        
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	public void testLengthSquared() 
	{
		Vector v1 = new Vector(1, 2, 3);
		assertTrue("lengthSquared() return wrong value", !isZero(v1.lengthSquared() - 14));
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	public void testLength() 
	{
	        assertTrue("lengthSquared() return wrong value", !isZero(new Vector(0, 3, 4).length() - 5));
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	public void testNormalize() //מנרמל את הווקטור
	{   
		Vector v = new Vector(1, 2, 3);
        Vector vCopy = new Vector(v.getHead());
        Vector vCopyNormalize = vCopy.normalize();
        assertTrue("ERROR: normalize() function creates a new vector", vCopy != vCopyNormalize);
        assertTrue("ERROR: normalize() result is not a unit vector", !isZero(vCopyNormalize.length() - 1));    
        

        
        v = new Vector(3.5,-5,10);
		v.normalize();
		assertEquals("", 1, v.length(),1e-10);
		
		v = new Vector(0,0,0);
		try 
		{
			v.normalize();
			fail("Didn't throw divide by zero exception!");
		} 
		catch (ArithmeticException e) 
		{
			assertTrue(true);
		}
		
	}

	/**
	 * Test method for {@link primitives.Vector#normalized()}.
	 */
	@Test
	public void testNormalized() //מביא וקטור מנורמל ב
	{
		Vector v = new Vector(1, 2, 3);    
        Vector u = v.normalized();
        assertTrue("ERROR: normalizated() function does not create a new vector", u == v );
	}
	

}
