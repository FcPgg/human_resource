package com.xt.ptus.mt.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_goods")
public class MtGoods extends BaseEntity {
	
	@Column(name = "categroy", columnDefinition = "int(10)")
	private int categroy;
	
	@Formula(value="(select a.cat_name from mt_category a where a.id = categroy)")
	private String catName;
	
	@Column(name = "att_id", columnDefinition = "int(10)")
	private int attId;
	
	@Formula("( select  concat_ws('.', s.uuid, s.src_file_type) from sys_attachments s where s.id = att_id)")
	private String logoAttUrl;
	
	
	@Column(name = "name", columnDefinition = "varchar(200)")
	private String name;
	
	@Column(name = "birthday", columnDefinition = "varchar(500)")
	private String birthday;
	
	@Column(name = "nation", columnDefinition = "varchar(500)")
	private String nation;
	
	@Column(name = "politics", columnDefinition = "varchar(500)")
	private String politics;
	
	@Column(name = "hobby", columnDefinition = "varchar(100)")
	private String hobby;
	
	@Column(name = "status", columnDefinition = "int(11)")
	private int status;
	
	@Column(name = "updator", columnDefinition = "int(11)")
	private int updator;
	
	@Column(name = "udpate_time", columnDefinition = "datetime")
	private Date udpateTime;
	
	@Column(name = "creator", columnDefinition = "int(11)")
	private int creator;
	
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	@Column(name = "education", columnDefinition = "varchar(11)")
	private String education;
	
	@Column(name = "description", columnDefinition = "varchar(500)")
	private String description;
	
	@Column(name = "undercarriage_time", columnDefinition = "datetime")
	private Date undercarriageTime;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;
	
	@Column(name = "postage", columnDefinition = "decimal(18,2)")
	private double postage;
	
	@Column(name = "cashback", columnDefinition = "decimal(18,2)")
	private double cashback;
	
	@Column(name = "idNumber", columnDefinition = "varchar(20)")
	private String idNumber;
	
	@Column(name = "telPhone", columnDefinition = "varchar(20)")
	private String telPhone;

	@Column(name = "school", columnDefinition = "varchar(100)")
	private String school;
	
	@Column(name = "major", columnDefinition = "varchar(50)")
	private String major;
	
	@Column(name = "sex", columnDefinition = "int(10)")
	private String sex;
	
	@Column(name = "detail_description", columnDefinition = "varchar(1000)")
	private String detailDescription;
	
	@Transient
	private int indexResourceId;
	
	@Formula("(select r.access_url from mt_material_resources r where r.id = (select g.resource_id from mt_goods_gallery g where g.goods_id = id and g.sort = 0))")
	private String indexResourceAccessUrl;
	

	/**
	 * 商品规格
	 */
	@Transient
	private List<MtGoodsSpec> goodsSpecs;
	
	@Transient
	private List<MtGoodsParams> goodsParams;
	
	@Transient
	private List<MtGoodsGallery> goodsGallery;
	
	@Transient
	private List<MtGoodsValuation> goodsValuations;
	
	@Transient
	private double minPrice;
	
	@Transient
	private double maxPrice;
	
	/**
	 * 商品月销量
	 * @return
	 */
	@Transient
	private int goodsMonthSaleCount;
	
	/**
	 * 商品总销量
	 * @return
	 */
	@Transient
	private int goodsSaleCount;
	
	
	
	public int getGoodsMonthSaleCount() {
		return goodsMonthSaleCount;
	}

	public void setGoodsMonthSaleCount(int goodsMonthSaleCount) {
		this.goodsMonthSaleCount = goodsMonthSaleCount;
	}

	public int getGoodsSaleCount() {
		return goodsSaleCount;
	}

	public void setGoodsSaleCount(int goodsSaleCount) {
		this.goodsSaleCount = goodsSaleCount;
	}

	
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	
	
	public int getStatus(){
		return this.status;
	}
	
	public void setStatus(int status){
		this.status = status;
	}
	
	public int getUpdator(){
		return this.updator;
	}
	
	public void setUpdator(int updator){
		this.updator = updator;
	}
	
	public Date getUdpateTime(){
		return this.udpateTime;
	}
	
	public void setUdpateTime(Date udpateTime){
		this.udpateTime = udpateTime;
	}
	
	public int getCreator(){
		return this.creator;
	}
	
	public void setCreator(int creator){
		this.creator = creator;
	}
	
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	

	public Date getUndercarriageTime() {
		return undercarriageTime;
	}

	public void setUndercarriageTime(Date undercarriageTime) {
		this.undercarriageTime = undercarriageTime;
	}

	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public double getPostage(){
		return this.postage;
	}
	
	public void setPostage(double postage){
		this.postage = postage;
	}
	
	public int getIndexResourceId(){
		return this.indexResourceId;
	}
	
	public void setIndexResourceId(int indexResourceId){
		this.indexResourceId = indexResourceId;
	}


	public List<MtGoodsSpec> getGoodsSpecs() {
		return goodsSpecs;
	}

	public void setGoodsSpecs(List<MtGoodsSpec> goodsSpecs) {
		this.goodsSpecs = goodsSpecs;
	}

	public List<MtGoodsParams> getGoodsParams() {
		return goodsParams;
	}

	public void setGoodsParams(List<MtGoodsParams> goodsParams) {
		this.goodsParams = goodsParams;
	}

	public List<MtGoodsGallery> getGoodsGallery() {
		return goodsGallery;
	}

	public void setGoodsGallery(List<MtGoodsGallery> goodsGallery) {
		this.goodsGallery = goodsGallery;
	}

	public String getIndexResourceAccessUrl() {
		return indexResourceAccessUrl;
	}

	public void setIndexResourceAccessUrl(String indexResourceAccessUrl) {
		this.indexResourceAccessUrl = indexResourceAccessUrl;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public List<MtGoodsValuation> getGoodsValuations() {
		return goodsValuations;
	}

	public void setGoodsValuations(List<MtGoodsValuation> goodsValuations) {
		this.goodsValuations = goodsValuations;
	}

	public double getCashback() {
		return cashback;
	}

	public void setCashback(double cashback) {
		this.cashback = cashback;
	}

	public int getCategroy() {
		return categroy;
	}

	public void setCategroy(int categroy) {
		this.categroy = categroy;
	}

	public int getAttId() {
		return attId;
	}

	public void setAttId(int attId) {
		this.attId = attId;
	}

	public String getLogoAttUrl() {
		return logoAttUrl;
	}

	public void setLogoAttUrl(String logoAttUrl) {
		this.logoAttUrl = logoAttUrl;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPolitics() {
		return politics;
	}

	public void setPolitics(String politics) {
		this.politics = politics;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
}
