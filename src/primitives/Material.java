/**
 * 
 */
package primitives;

/**
 * @author ����� �����
 *
 */
public class Material 
{

	/**
	 * 
	 */
	
	public int nShininess=0; //�� ��� ����� ���� �����
	public double KD=0; //��� ����� ����� ���
	public double KS=0; //��� ����� ����� ����
	public double KT=0.0; //Promotes transparency ���� ������
	public double KR=0.0; //Coefficient of reflection ���� �������
	
	
	/**
	 * @param kT the kT to set
	 */
	public Material setKT(double kT) 
	{
		KT = kT;
		return this;
	}

	/**
	 * @param kR the kR to set
	 */
	public Material setKR(double kR) 
	{
		KR = kR;
		return this;
	}

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


}
