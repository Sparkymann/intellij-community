// Generated by delombok at Sat Jun 11 11:12:44 CEST 2016

class BuilderWithToBuilderOnMethod<T, K> {
	private String one;
	private String two;
	private T foo;
	private K bar;
	private int some;

	public static <Z> BuilderWithToBuilderOnMethod<Z, String> test(String one, Z bar) {
		return new BuilderWithToBuilderOnMethod<Z, String>();
	}


	@java.lang.SuppressWarnings("all")
	@javax.annotation.Generated("lombok")
	public static class BuilderWithToBuilderOnMethodBuilder<Z> {
		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		private String one;
		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		private Z bar;

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		BuilderWithToBuilderOnMethodBuilder() {
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public BuilderWithToBuilderOnMethodBuilder<Z> one(final String one) {
			this.one = one;
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public BuilderWithToBuilderOnMethodBuilder<Z> bar(final Z bar) {
			this.bar = bar;
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public BuilderWithToBuilderOnMethod build() {
			return BuilderWithToBuilderOnMethod.<Z>test(one, bar);
		}

		@java.lang.Override
		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public java.lang.String toString() {
			return "BuilderWithToBuilderOnMethod.BuilderWithToBuilderOnMethodBuilder(one=" + this.one + ", bar=" + this.bar + ")";
		}
	}

	@java.lang.SuppressWarnings("all")
	@javax.annotation.Generated("lombok")
	public static <Z> BuilderWithToBuilderOnMethodBuilder<Z> builder() {
		return new BuilderWithToBuilderOnMethodBuilder<Z>();
	}

	@java.lang.SuppressWarnings("all")
	@javax.annotation.Generated("lombok")
	public BuilderWithToBuilderOnMethodBuilder<T> toBuilder() {
		return new BuilderWithToBuilderOnMethodBuilder<T>().one(this.one).bar(this.foo);
	}
}
