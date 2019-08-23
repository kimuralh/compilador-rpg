public abstract class Comando
{
	public String type;
	public Object value;
	public abstract String toJava();
}