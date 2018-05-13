package priv.lst.arch.redis;

import java.io.Serializable;

class TestUser implements Serializable {
	private static final long serialVersionUID = 1L;

		public TestUser() {
		super();
	}

		public TestUser(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

		private String name;
		
		private int age;
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
	}