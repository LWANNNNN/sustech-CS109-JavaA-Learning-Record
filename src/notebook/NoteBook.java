package notebook;
import java.util.ArrayList;

public class NoteBook
{
    private ArrayList<String> notes = new ArrayList<String>();

    public void add (String s)
    {
        notes.add(s);
    }

    public int getSize()
    {
        return notes.size();
    }

    public String getNote (int index)
    {
        return notes.get (index);
    }

    public void removeNote (int index)
    {
    }

    public String[] list()
    {
        return new String[10];
    }

    public static void main(String[] args)
    {
        NoteBook notebook = new NoteBook();
        notebook.add ("first");
        notebook.add ("second");
        notebook.add ("third");
        notebook.getSize();
        notebook.removeNote (2);
    }
}
