/**
 * 
 */
package primitives;

/**
 * @author אודיה סעדון
 *
 */
public class Material 
{

	/**
	 * 
	 */
	
	public int nShininess=0;
	public double KD=0;
	public double KS=0;
	
	/**
	 * @param nShininess the nShininess to set
	 */
	public Material setnShininess(int nShininess) 
	{
		this.nShininess = nShininess;
		return this;
		
	}

	/**
	 * @param kD the kD to set
	 */
	public Material setKD(double kD) 
	{
		KD = kD;
		return this;
	}

	/**
	 * @param kS the kS to set
	 */
	public Material setKS(double kS) 
	{
		KS = kS;
		return this;
	}

	public Material() 
	{
		// TODO Auto-generated constructor stub
	}

}
