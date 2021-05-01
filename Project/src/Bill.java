import java.sql.Date;
import java.util.*;

public class Bill {
    private Map<Integer, Integer> mPurchase;
    private User user;
    private Date date;
    public int money;
    public Bill(User user)
    {
        mPurchase = new HashMap<Integer, Integer>();
        this.user=user;
        long millis=System.currentTimeMillis();
        date = new Date(millis);
        money = 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return date;
    }

    public void setTime(Date date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void action(int id, int soluong, int gia)
    {
        int soLuongCu;
        if(mPurchase.get(id) == null) soLuongCu = 0;
        else soLuongCu = mPurchase.get(id);
        int soLuongMoi = soLuongCu + soluong;
        money += gia*soluong;
        mPurchase.put(id,soLuongMoi);
    }
    public  void inThongTin()
    {
        Set<Integer> set = mPurchase.keySet();
        for(Integer key:set)
        {
            System.out.println("Thiet bi id: "+key+" so luong:"+mPurchase.get(key));

        }
        System.out.println("Tong gia phai tra la: "+money);
        System.out.println("thoi gian "+date);

    }
}
