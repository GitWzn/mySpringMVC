package com.wzn188.VO;

import org.hibernate.validator.constraints.NotBlank;

import com.wzn188.myInterface.IAddUserGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
	@NotBlank(message="{phone.error.msg}", groups={IAddUserGroup.class})
	private String phone;
	@NotBlank(message="地址不符合要求!")
	private String address;
}
