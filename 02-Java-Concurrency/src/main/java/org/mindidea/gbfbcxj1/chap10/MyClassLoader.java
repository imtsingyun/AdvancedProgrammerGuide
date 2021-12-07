package org.mindidea.gbfbcxj1.chap10;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

	private final static Path DEFAULT_CLASS_DIR = Paths.get("D:", "classloader1");

	private final Path classDir;

	public MyClassLoader() {
		super();
		this.classDir = DEFAULT_CLASS_DIR;
	}

	public MyClassLoader(String classDir) {
		super();
		this.classDir = Paths.get(classDir);
	}

	public MyClassLoader(String classDir, ClassLoader parent) {
		super(parent);
		this.classDir = Paths.get(classDir);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classbyte = this.readClassBytes(name);
		if (null == classbyte || classbyte.length == 0) {
			throw new ClassNotFoundException("Can not load the class " + name);
		}
		return this.defineClass(name, classbyte, 0, classbyte.length);
	}

	private byte[] readClassBytes(String name) throws ClassNotFoundException {
		String classPath = name.replace(".", "/");
		Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
		if (!classFullPath.toFile().exists()) {
			throw new ClassNotFoundException("The class " + name + " not found.");
		}
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Files.copy(classFullPath, byteArrayOutputStream);
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			throw new ClassNotFoundException("load the class " + name + " occur error.", e);
		}
	}
}
