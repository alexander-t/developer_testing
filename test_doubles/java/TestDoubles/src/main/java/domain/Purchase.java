package domain;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private List<Item> items = new ArrayList<>();
/*
    public double Price
    {
        get {
        return items.Aggregate(0.0, (total, next) => total += next.Price);
    }
    }

    public int ItemCount { get { return items.Count; } }
*/
    public void addItem(Item item)
    {
        items.add(item);
    }
/*
    public override bool Equals(Object o)
    {
        if (o == null || GetType() != o.GetType())
            return false;

        Purchase that = (Purchase)o;
        return items.SequenceEqual(that.items);
    }

    public override int GetHashCode()
    {
        return items.GetHashCode();
    }
*/
}
