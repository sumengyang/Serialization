# Serialization
  1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
  
  2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。
  变量如果是用户自定义类变量，则该类需要实现Serializable接口。

  3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
  
  第三点可能有些人很迷惑，因为发现在User类中的username字段前加上static关键字后，程序运行结果依然不变，
  即static类型的username也读出来为“Alexia”了，这不与第三点说的矛盾吗？
  实际上是这样的：第三点确实没错（一个静态变量不管是否被transient修饰，均不能被序列化），反序列化后类中
  static型变量username的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的
  
  
  在Java中，对象的序列化可以通过实现两种接口来实现，若实现的是Serializable接口，则所有的序列化将会自动进行，
  若实现的是Externalizable接口，则没有任何东西可以自动序列化， 需要在writeExternal方法中进行手工指定所要
  序列化的变量，这与是否被transient修饰无关。
