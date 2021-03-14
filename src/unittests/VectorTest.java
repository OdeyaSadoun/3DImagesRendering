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
public class VectorTest 
{

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	
	@Test
	public void testAdd() 
	{
		Vector v1;
		Vector v2;
		Vector vTry;
		
		// ============ Equivalence Partitions Tests ==============
		try 
		{
			v1= new Vector(2,4,6);
			v2= new Vector(7,8,9);	
			vTry= new Vector(9,12,15);
			assertTrue("Add() Did not add the vector correct", vTry.equals(v1.add(v2)));
			
		} 
		catch (Exception e) 
		{
			fail("Add() for vectors that not zero vector does not need throw an exception");
		}

		try 
		{
			v1= new Vector(-1,-6,-4.2);
			v2= new Vector(-2,-5.1,-9);
			vTry=new Vector(-3,-11.1,-13.2);
			assertTrue("Add() Did not add the vector correct", vTry.equals(v1.add(v2)));
		} 
		catch (Exception e) 
		{
			fail("Add() for vectors that not zero vector does not need throw an exception");
		}

		try 
		{
			v1= new Vector(-1,8,23);
			v2= new Vector(6,-5.1,3);
			vTry=new Vector(5,2.9,26);
			assertTrue("Add() Did not add the vector correct", vTry.equals(v1.add(v2)));
		} 
		catch (Exception e) 
		{
			fail("Add() for vectors that not zero vector does not need throw an exception");
		}
		

		
		// =============== Boundary Values Tests ==================
		try 
		{
			v1= new Vector(-1,8,23);
			//add (0,0,0):
			assertTrue("Add() Did not add the vector correct", v1.getHead().equals(Point3D.ZERO.add(v1)));
			
			@SuppressWarnings("unused")
			Vector vZero = new Vector(Point3D.ZERO);
			//if we don't get an exception it is didn't work correct
			fail("can not create a new vector that his head equals to zero vector");
		} 
		catch (IllegalArgumentException e) {}
		catch (Exception e) {}

	}

	/**
	 * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
	 */
	@Test
	public void testSubtract() 
	{
		// ============ Equivalence Partitions Tests ==============
		Vector v1;
		Vector v2;
		Vector vTry;
		try 
		{
			v1 = new Vector(2,4,6);
			v2=new Vector(7,8,9);		
			vTry=new Vector(-5,-4,-3);
			assertTrue("Subtract() Did not sub the vector correct", vTry.equals(v1.subtract(v2)));
		} 
		catch (Exception e) 
		{
			fail("Subtract() for vectors that not zero vector does not need throw an exception");
		}
		
		try 
		{
			v1 = new Vector(9,5,4);
			v2=new Vector(5,2,3);		
			vTry=new Vector(4,3,1);
			assertTrue("Subtract() Did not sub the vector correct", vTry.equals(v1.subtract(v2)));
		} 
		catch (Exception e) 
		{
			fail("Subtract() for vectors that not zero vector does not need throw an exception");
		}
		
		try 
		{
			v1 = new Vector(-5,-5,-4);
			v2=new Vector(-9,-1,-12);		
			vTry=new Vector(4,-4,8);
			assertTrue("Subtract() Did not sub the vector correct", vTry.equals(v1.subtract(v2)));
		} 
		catch (Exception e) 
		{
			fail("Subtract() for vectors that not zero vector does not need throw an exception");
		}
		
		try 
		{
			v1 = new Vector(-5,-5,-4);
			v2=new Vector(3,9,4);		
			vTry=new Vector(-8,-14,-8);
			assertTrue("Subtract() Did not sub the vector correct", vTry.equals(v1.subtract(v2)));
		} 
		catch (Exception e) 
		{
			fail("Subtract() for vectors that not zero vector does not need throw an exception");
		}

		
		// =============== Boundary Values Tests ==================
		
		try 
		{
			v1 = new Vector(-5,-5,-4);
			assertTrue("Subtract() Did not sub the vector correct when the other vector is the zero vector", v1.equals(v1.getHead().subtract(Point3D.ZERO)));
			
			@SuppressWarnings("unused")
			Vector vZero = new Vector(Point3D.ZERO);
			//if we don't get an exception it is didn't work correct
			fail("can not create a new vector that his head equals to zero vector");

		} 
		catch (IllegalArgumentException e) {}
		catch (Exception e) {}
	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test
	public void testScale() 
	{
		// ============ Equivalence Partitions Tests ==============
		Vector v1;
		Vector vTry;
		try 
		{
			v1 = new Vector(2,4,6);
			//scalar: 3.5
			vTry=new Vector(7,14,21);
			assertTrue("Scale() Did not double the vector correct", vTry.equals(v1.scale(3.5)));
		} 
		catch (Exception e) 
		{
			fail("Scale() for vectors that not zero vector does not need throw an exception");
		}
		
		try 
		{
			v1 = new Vector(2,4,6);
			//scalar: -5
			vTry=new Vector(-10,-20,-30);
			assertTrue("Scale() Did not double the vector correct", vTry.equals(v1.scale(-5)));	
		} 
		catch (Exception e) 
		{
			fail("Scale() for vectors that not zero vector does not need throw an exception");
		}


		
		// =============== Boundary Values Tests ==================
		//scalar: 0
		try 
		{
			v1 = new Vector(-5,-5,-4);
			assertTrue("Scale() Did not double the vector correct when the scalar is 0", v1.equals(v1.scale(0)));
			
			@SuppressWarnings("unused")
			Vector vZero = new Vector(Point3D.ZERO);
			//if we don't get an exception it is didn't work correct
			fail("can not create a new vector that his head equals to zero vector");

		} 
		catch (IllegalArgumentException e) {}
		catch (Exception e) {}

	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	public void testCrossProduct() 
	{
        Vector v1;
        Vector v2;
		try 
		{
			v1 = new Vector(1, 2, 3);
			v2 = new Vector(-2, -4, -6);
	        // ============ Equivalence Partitions Tests ==============
	        Vector v3 = new Vector(0, 3, -2);
	        Vector vr = v1.crossProduct(v3);

	        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
	        assertEquals("crossProduct() wrong result length", v1.length() * v3.length(), vr.length(), 0.00001);

	        // Test cross-product result orthogonality to its operands
	        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
	        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v3)));

		}
		catch (Exception e)
		{
			fail("CrossProduct() for vectors that not zero vector does not need throw an exception");
		}

        // =============== Boundary Values Tests ==================
        // test zero vector from cross-productof co-lined vectors
        try
        {
        	v1 = new Vector(1, 2, 3);
			v2 = new Vector(-2, -4, -6);
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        }
        catch (Exception e)
        {}
     
    }


	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	public void testDotProduct() 
	{
		  Vector v1;
		  Vector v2;
		  Vector v3;
		try 
		{
			v1 = new Vector(1, 2, 3);
			v2 = new Vector(-2, -4, -6);
		    v3 = new Vector(0, 3, -2);
		    assertTrue("ERROR: dotProduct() for orthogonal vectors is not zero", isZero(v1.dotProduct(v3)));
		    assertTrue("ERROR: dotProduct() wrong value",isZero(v1.dotProduct(v2) + 28));
		} 
		catch (Exception e) 
		{
			fail("DotProduct() for vectors that not zero vector does not need throw an exception");
		}
	      
        
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	public void testLengthSquared() 
	{
		Vector v1;
		try 
		{
			v1 = new Vector(1, 2, 3);
			assertTrue("lengthSquared() return wrong value", isZero(v1.lengthSquared() - 14));
		} 
		catch (Exception e) 
		{
			fail("LengthSquared() for vectors that not zero vector does not need throw an exception");
		}
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	public void testLength() 
	{
		try
		{
			assertTrue("Length() return wrong value", isZero(new Vector(0, 3, 4).length() - 5));
		}
		catch (Exception e) 
		{
			fail("Length() for vectors that not zero vector does not need throw an exception");
		}
		
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	public void testNormalize() //מנרמל את הווקטור
	{   
		Vector v;
		Vector vCopy;
		Vector vCopyNormalize;
		try 
		{
			v = new Vector(1, 2, 3);
			vCopy = new Vector(v.getHead());//vcopy==v
			vCopyNormalize = vCopy.normalize();
			assertFalse("ERROR: normalize() function creates a new vector", vCopy != vCopyNormalize);
			assertTrue("ERROR: normalize() result is not a unit vector", isZero(vCopyNormalize.length() - 1));    
		} 
		catch (Exception e) 
		{
			fail("Normalize() for vectors that not zero vector does not need throw an exception");
		}

		try 
		{
			v = new Vector(3.5,-5,10);
			v.normalize();
			assertEquals("ERROR: normalize() result is not a unit vector", 1, v.length(),1e-10);
		}
		catch (Exception e) {}
		
		try
		{
			v = new Vector(0,0,0);
			v.normalize();
			fail("Didn't throw divide by zero exception!");
		} 
		catch (ArithmeticException e) 
		{
			assertTrue(true);
		} 
		catch (Exception e) {}
		
	}

	/**
	 * Test method for {@link primitives.Vector#normalized()}.
	 */
	@Test
	public void testNormalized() //מביא וקטור מנורמל ב
	{
		Vector v;
		try
		{
			v = new Vector(1, 2, 3);
			Vector u = v.normalized();
			assertTrue("ERROR: normalizated() result is not a unit vector", isZero(u.length() - 1));    
			assertFalse("ERROR: normalizated() function does not create a new vector", u == v );//?
		} 
		catch (Exception e) 
		{
			fail("Normalized() for vectors that not zero vector does not need throw an exception");
		}    
	}
	

}
