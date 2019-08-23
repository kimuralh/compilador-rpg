public abstract class Comando
{
	public String type;
	public Object value;
	public Expressao expression;
	public abstract String toJava();
}