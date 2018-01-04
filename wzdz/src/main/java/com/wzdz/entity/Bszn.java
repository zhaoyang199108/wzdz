package com.wzdz.entity;

import java.util.Date;

/**
 * 办事指南
 * @author man
 *
 */
public class Bszn {
	
	private String id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String sxbm;//事项编码
	private String sxfl;//事项分类
	private String sxmc;//事项名称
	private String sxxz;//事项性质
	private String sscj;//实施层级
	private String xsyj;//行使依据
	private String blzt;//办理主体
	private String sltj;//受理条件
	private String sfyj;//收费依据
	private String fdqx;//法定期限
	private String cnqx;//承诺期限
	private String bldz;//办理地址
	private String lxdh;//联系电话
	private String fwbg;//服务表格
	private String jddh;//监督电话
	private String zxbl;//在线办理链接
	
	private String type;
	private String typeName;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getSxbm() {
		return sxbm;
	}
	public void setSxbm(String sxbm) {
		this.sxbm = sxbm;
	}
	public String getSxfl() {
		return sxfl;
	}
	public void setSxfl(String sxfl) {
		this.sxfl = sxfl;
	}
	public String getSxmc() {
		return sxmc;
	}
	public void setSxmc(String sxmc) {
		this.sxmc = sxmc;
	}
	public String getSxxz() {
		return sxxz;
	}
	public void setSxxz(String sxxz) {
		this.sxxz = sxxz;
	}

	public String getSscj() {
		return sscj;
	}
	public void setSscj(String sscj) {
		this.sscj = sscj;
	}
	public String getXsyj() {
		return xsyj;
	}
	public void setXsyj(String xsyj) {
		this.xsyj = xsyj;
	}
	public String getBlzt() {
		return blzt;
	}
	public void setBlzt(String blzt) {
		this.blzt = blzt;
	}
	public String getSfyj() {
		return sfyj;
	}
	public void setSfyj(String sfyj) {
		this.sfyj = sfyj;
	}
	public String getFdqx() {
		return fdqx;
	}
	public void setFdqx(String fdqx) {
		this.fdqx = fdqx;
	}
	public String getCnqx() {
		return cnqx;
	}
	public void setCnqx(String cnqx) {
		this.cnqx = cnqx;
	}
	public String getBldz() {
		return bldz;
	}
	public void setBldz(String bldz) {
		this.bldz = bldz;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getFwbg() {
		return fwbg;
	}
	public void setFwbg(String fwbg) {
		this.fwbg = fwbg;
	}
	public String getJddh() {
		return jddh;
	}
	public void setJddh(String jddh) {
		this.jddh = jddh;
	}
	public String getZxbl() {
		return zxbl;
	}
	public void setZxbl(String zxbl) {
		this.zxbl = zxbl;
	}
	public String getSltj() {
		return sltj;
	}
	public void setSltj(String sltj) {
		this.sltj = sltj;
	}
}
