In a multi-threaded environment, the lock-free algorithms provide a way in which threads can access the shared resources without the complexity of Locks and without blocking the threads forever. These algorithms become a programmer’s choice as they provide higher throughput and prevent deadlocks.

This is mainly because designing lock-based algorithms, for concurrency brings its own challenges on the table. The complexity of writing efficient locks and synchronization to reduce thread contention is not everyone’s cup of tea. And besides, even after writing the complex code, many times, hard-to-find bugs occur in the production environments, where multiple threads are involved, which becomes even more difficult to resolve.
Keeping this perspective, we will be talking about how we can apply a lock-free algorithm to one of the widely used data structures in Java, called the Stack. As we know Stack is used in many real-life applications like Undo/redo functions in a Word processor, Expression evaluation and syntax parsing, in Language Processing, in supporting recursions and also our own JVM is Stack oriented. So, let’s have some insight into how to write a lock-free stack. Hope it ignites your mind enough to read and gain knowledge on this topic, further.

##Atomic Classes in Java
Java provides a plethora of classes that support lock-free and thread-safe programming. The Atomic API provided by Java, java.util.concurrent.atomic package contains many advanced classes and features which provide concurrency control without having to use locks. The AtomicReference is also one such class in the API which provides a reference to the underlying object references that can be read and written atomically. By atomic, we mean the reads from and writes to these variables are thread-safe. Please refer to the below link for details.


## Treiber stack
The Treiber stack algorithm is a scalable lock-free stack utilizing the fine-grained concurrency primitive compare-and-swap.[1] It is believed that R. Kent Treiber was the first to publish it in his 1986 article "Systems Programming: Coping with Parallelism".[2]
The basic principle for the algorithm is to only add something new to the stack once you know the item you are trying to add is the only thing that has been added since you began the operation. This is done by using compare-and-swap. Pushing an item to the stack is done by first taking the top of the stack (old head) and placing it after your new item to create a new head. You then compare the old head to the current head. If the two are matching then you can swap old head to the new one, if not then it means another thread has added an item to the stack, in which case you must try again.

When popping an item from the stack, before returning the item you must check that another thread has not added a new item since the operation began.

