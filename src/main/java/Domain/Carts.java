package Domain;
/*

Create Table

CREATE TABLE `tb_cart` (
  `id` int(11) NOT NULL,
  `pid` int(11) NOT NULL DEFAULT '0',
  `Num` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`pid`),
  KEY `fk_cart_pid` (`pid`),
  CONSTRAINT `fk_cart_id` FOREIGN KEY (`id`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `fk_cart_pid` FOREIGN KEY (`pid`) REFERENCES `tb_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */
public class Carts {
    private int id;
    private int pid;
    private int Num;
    private int money;
    private Goods goods;

    public Carts() {
    }

    public Carts(int id, int pid, int num, int money) {
        this.id = id;
        this.pid = pid;
        Num = num;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Carts{" +
                "id=" + id +
                ", pid=" + pid +
                ", Num=" + Num +
                ", money=" + money +
                '}';
    }
}
