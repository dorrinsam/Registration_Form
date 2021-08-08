
public class StudentClass {
	private String student_username;
	private String student_level;
	public void setUs(String student_username)
	{
		this.student_username=student_username;
	}
	public String getstudent_username()
	{
		return student_username;
	}
	public void setlevel(String student_level)
	{
		this.student_level=student_level;
	}
	public String getstudent_level()
	{
		return student_level;
	}
	public String toString()
	{
		return student_username+""+student_level;
	}

}
