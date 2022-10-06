package com.biblos.enums;

public enum EnumRoleKey{
	BACKEND("DOTCMS_BACK_END_USER");
	
	private String key;

	EnumRoleKey(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}