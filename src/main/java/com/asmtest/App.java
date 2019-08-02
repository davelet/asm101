package com.asmtest;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import java.io.IOException;
import java.util.Arrays;

/**
 * <pre>
 * <b>Description</b>
 * </pre>
 * <pre>
 * 创建时间 2019-08-01 19:14
 * 所属工程： asm101  </pre>
 *
 * @author sheldon yhid: 80752866
 */
public class App {
    public static void main(String[] args) throws IOException {
        classReader();
    }

    private static void classReader() throws IOException {
        ClassReader cr = new ClassReader("com.asmtest.asm.Klazz");
        String className = cr.getClassName();
        System.out.println(className);
        System.out.println(Arrays.toString(cr.getInterfaces()));
        System.out.println(cr.getItemCount());
        System.out.println(cr.getSuperName());
        System.out.println("-----");
        cr.accept(new ClassOut(), 0);
    }

    static class ClassOut extends ClassVisitor {

        public ClassOut() {
            super(Opcodes.ASM7);
        }

        @Override
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            super.visit(version, access, name, signature, superName, interfaces);
            System.out.println(name + " extends " + superName + " {");
        }

        @Override
        public void visitSource(String source, String debug) {
            super.visitSource(source, debug);
            System.out.println("// 源文件是" + source);
        }

        @Override
        public ModuleVisitor visitModule(String name, int access, String version) {
            System.out.println("模块是" + name + version);
            return super.visitModule(name, access, version);
        }

        @Override
        public void visitNestHost(String nestHost) {
            System.out.println("寄主类是" + nestHost);
            super.visitNestHost(nestHost);
        }

        @Override
        public void visitOuterClass(String owner, String name, String descriptor) {
            System.out.println("宿主类是" + owner + name);
            super.visitOuterClass(owner, name, descriptor);
        }

        @Override
        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
            System.out.println("注解是" + descriptor);
            return super.visitAnnotation(descriptor, visible);
        }

        @Override
        public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
            System.out.println("类上注解" + descriptor);
            return super.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        }

        @Override
        public void visitAttribute(Attribute attribute) {
            System.out.println("属性是" + attribute);
            super.visitAttribute(attribute);
        }

        @Override
        public void visitNestMember(String nestMember) {
            System.out.println("嵌套类是" + nestMember);
            super.visitNestMember(nestMember);
        }

        @Override
        public void visitInnerClass(String name, String outerName, String innerName, int access) {
            System.out.println("内部类是" + name + outerName + innerName + access);
            super.visitInnerClass(name, outerName, innerName, access);
        }

        @Override
        public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
            System.out.println("字段是" + access + name + descriptor + signature + value);
            FieldVisitor field = super.visitField(access, name, descriptor, signature, value);
            return field;
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            System.out.println("方法是" + name + descriptor);
            return super.visitMethod(access, name, descriptor, signature, exceptions);
        }

        @Override
        public void visitEnd() {
            super.visitEnd();
            System.out.println("}");
        }
    }
}
