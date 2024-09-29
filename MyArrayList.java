public class MyArrayList implements MyList
{
    private Object[] data;
    public MyArrayList()
    {
        data = new Object[0];
    }
    public boolean add(Object obj)
    {
        Object[] newData = new Object[data.length + 1];
        for(int i = 0; i < data.length; i++)
        {
            newData[i] = data[i];
        }
        newData[newData.length - 1] = obj;
        data = newData;
        return true;
    }
    public void add(int index, Object obj)
    {
        Object[] newData;
        if(index >= data.length)
        {
            newData = new Object[data.length + 1];
            newData[newData.length - 1] = obj;
            for(int i = 0; i < newData.length-1; i++)
            {
                newData[i] = data[i];
            }
            data = newData;
        }
        else if(index <= 0)
        {
            newData = new Object[data.length + 1];
            newData[0] = obj;
            for(int i = 1; i < newData.length; i++)
            {
                newData[i] = data[i-1];
            }
            data = newData;
        }
        else{
            newData = new Object[data.length + 1];
            for(int i = 0; i < data.length;i++)
            {
                if(i<index)
                    newData[i] = data[i];
                if(i>=index)
                    newData[i+1] = data[i];
                
            }

            newData[index] = obj;
            data = newData;
        }
    }
    public boolean contains(Object obj)
    {
        if(obj.equals(null))
            return false;
        for(int i = 0; i < data.length; i++)
        {
            if(data[i].equals(obj))
            return true;
        }
        return false;
    }
    public Object get(int index)
    {
        if(index > data.length - 1 || index < 0)
            return null;
        return data[index];
    }
    public boolean isEmpty()
    {
        if(data.equals(null))
            return false;
        if(data.length == 0)
            return true;
        return false;
    }
    public Object remove(int index)
    {
      if(data.equals(null) || index >= data.length || index < 0)
        return null;
      Object[] newData = new Object[data.length - 1];
      Object removed = data[index];
      int m = 0;
      for(int i = 0; i < data.length; i++)
        {
           if(i == index)
               continue;
           newData[m] = data[i];
           m++;
        }
      data = newData;
      return removed;
    }
    public boolean remove(Object obj)
    {
      for(int i = 0; i < data.length; i++){
        if(data[i] == null)
            continue;
        if(data[i].equals(obj)){
            remove(i);
            return true;
        }
      }
      return false;
    }
    public Object set(int index, Object obj)
    {
        if(data.equals(null) || obj.equals(null) || index >= data.length || index < 0)
            return null;
        Object replaced = data[index];
        data[index] = obj;
        return replaced;
    }
    public int size()
    {
        int size = 0;
        for(int i = 0; i < data.length; i++)
            if(data[i] != null)
                size++;
         
        return size;
    }
}