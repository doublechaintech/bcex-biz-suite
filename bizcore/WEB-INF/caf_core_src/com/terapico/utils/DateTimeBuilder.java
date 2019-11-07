package com.terapico.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeBuilder {
	protected Date seedDate;
	protected LocalDateTime workingDate;
	protected ZoneId zoneId;
	
	
	public DateTimeBuilder() {
		this(new Date());
	}
	public DateTimeBuilder(Date date) {
		this(date, ZoneId.systemDefault());
	}
	public DateTimeBuilder(Date date, ZoneId zoneId) {
		this.seedDate = date;
		this.zoneId = zoneId;
		this.workingDate = toLocalDate(date);
	}
	public Date getDate() {
		return Date.from(workingDate.atZone(zoneId).toInstant());
	}
	public LocalDateTime getLocalDateTime() {
		return workingDate;
	}
	
	private LocalDateTime toLocalDate(Date input) {
		if (input instanceof java.sql.Date) {
			return new Date(input.getTime()).toInstant().atZone(zoneId).toLocalDateTime();
		}
		return input.toInstant().atZone(zoneId).toLocalDateTime();
	}
	
	// 年 级别的调整
	public DateTimeBuilder startOfYear() {
		workingDate = workingDate.with(TemporalAdjusters.firstDayOfYear());
		return this;
	}
	public DateTimeBuilder endOfYear() {
		workingDate = workingDate.with(TemporalAdjusters.lastDayOfYear());
		return this;
	}
	public DateTimeBuilder nextYear() {
		return addYears(1);
	}
	public DateTimeBuilder previousYear() {
		return addYears(-1);
	}
	public DateTimeBuilder addYears(long Years) {
		workingDate = workingDate.plusYears(Years);
		return this;
	}
	// 月 级别的调整
	public DateTimeBuilder startOfMonth() {
		workingDate = workingDate.with(TemporalAdjusters.firstDayOfMonth());
		return this;
	}
	public DateTimeBuilder endOfMonth() {
		workingDate = workingDate.with(TemporalAdjusters.lastDayOfMonth());
		return this;
	}
	public DateTimeBuilder nextMonth() {
		return addMonths(1);
	}
	public DateTimeBuilder previousMonth() {
		return addMonths(-1);
	}
	public DateTimeBuilder addMonths(long months) {
		workingDate = workingDate.plusMonths(months);
		return this;
	}
	// 天级别的调整
	public DateTimeBuilder startOfDay() {
		workingDate = workingDate.toLocalDate().atStartOfDay();
		return this;
	}
	public DateTimeBuilder endOfDay() {
		workingDate = workingDate.toLocalDate().atTime(LocalTime.MAX);
		return this;
	}
	public DateTimeBuilder nextDay() {
		return addDays(1);
	}
	public DateTimeBuilder previousDay() {
		return addDays(-1);
	}
	public DateTimeBuilder addDays(long days) {
		workingDate = workingDate.plusDays(days);
		return this;
	}
	// 日 内的调整
	public DateTimeBuilder atTime(int hour, int min, int sec) {
		workingDate = workingDate.toLocalDate().atTime(hour, min, sec);
		return this;
	}
	public DateTimeBuilder addHours(long hours) {
		workingDate = workingDate.plusHours(hours);
		return this;
	}
	public DateTimeBuilder addMinutes(long minutes) {
		workingDate = workingDate.plusMinutes(minutes);
		return this;
	}
	public DateTimeBuilder addSeconds(long seconds) {
		workingDate = workingDate.plusSeconds(seconds);
		return this;
	}
	
	
}
