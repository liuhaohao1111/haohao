package Domain;

import java.util.Date;

/*

Create Table

CREATE TABLE `tb_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `pubdate` date DEFAULT NULL,
  `picture` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `star` tinyint(4) NOT NULL DEFAULT '0',
  `intro` text,
  `typeid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_typeid` (`typeid`),
  CONSTRAINT `fk_typeid` FOREIGN KEY (`typeid`) REFERENCES `tb_goods_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8

 */
public class Goods {
    private int id;
    private String name;
    private Date pubdate;
    private String picture;
    private int price;
    private int star;
    private String intro;
    private int typeid;
    private GoodsType goodsType;

    public Goods() {
    }

    public Goods(int id, String name, Date pubdate, String picture, int price, int star, String intro, int typeid) {
        this.id = id;
        this.name = name;
        this.pubdate = pubdate;
        this.picture = picture;
        this.price = price;
        this.star = star;
        this.intro = intro;
        this.typeid = typeid;
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

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pubdate=" + pubdate +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", star=" + star +
                ", intro='" + intro + '\'' +
                ", typeid=" + typeid +
                '}';
    }
}
