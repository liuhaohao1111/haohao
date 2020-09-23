package Domain;
/*
CREATE TABLE `tb_orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Oid` varchar(100) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `Money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_pid` (`pid`),
  KEY `fk_order_id` (`Oid`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`Oid`) REFERENCES `tb_order` (`id`),
  CONSTRAINT `fk_order_pid` FOREIGN KEY (`pid`) REFERENCES `tb_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */
public class OrderDetail {
    private int id;
    private String Oid;
    private int pid;
    private int num;
    private int money;
    private Goods goods;
    public OrderDetail() {
    }

    public OrderDetail(int id, String oid, int pid, int num, int money) {
        this.id = id;
        Oid = oid;
        this.pid = pid;
        this.num = num;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOid() {
        return Oid;
    }

    public void setOid(String oid) {
        Oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
        return "OrderDetail{" +
                "id=" + id +
                ", Oid='" + Oid + '\'' +
                ", pid=" + pid +
                ", num=" + num +
                ", money=" + money +
                '}';
    }
}
