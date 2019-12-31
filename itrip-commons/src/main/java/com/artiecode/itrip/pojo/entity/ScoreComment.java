package com.artiecode.itrip.pojo.entity;

import java.io.Serializable;

/**
 * <b>酒店评分实体类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class ScoreComment implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double avgPositionScore;
	private Double avgFacilitiesScore;
	private Double avgServiceScore;
	private Double avgHygieneScore;
	private Double avgScore;

	public Double getAvgPositionScore() {
		return avgPositionScore;
	}

	public void setAvgPositionScore(Double avgPositionScore) {
		this.avgPositionScore = avgPositionScore;
	}

	public Double getAvgFacilitiesScore() {
		return avgFacilitiesScore;
	}

	public void setAvgFacilitiesScore(Double avgFacilitiesScore) {
		this.avgFacilitiesScore = avgFacilitiesScore;
	}

	public Double getAvgServiceScore() {
		return avgServiceScore;
	}

	public void setAvgServiceScore(Double avgServiceScore) {
		this.avgServiceScore = avgServiceScore;
	}

	public Double getAvgHygieneScore() {
		return avgHygieneScore;
	}

	public void setAvgHygieneScore(Double avgHygieneScore) {
		this.avgHygieneScore = avgHygieneScore;
	}

	public Double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}
}
