package Domain;
/*

Create Table

CREATE TABLE `tb_goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `Parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8

 */
public class GoodsType {
    private int id;
    private String name;
    private int level;
    private int Parent;

    public GoodsType() {
    }

    public GoodsType(int id, String name, int level, int parent) {
        this.id = id;
        this.name = name;
        this.level = level;
        Parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParent() {
        return Parent;
    }

    public void setParent(int parent) {
        Parent = parent;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", Parent=" + Parent +
                '}';
    }
}
