https://llimllib.github.io/bloomfilter-tutorial/
A Bloom filter is a data structure designed to tell you, rapidly and memory-efficiently, whether an element is present in a set.

The price paid for this efficiency is that a Bloom filter is a probabilistic data structure: it tells us that the element either definitely is not in the set or may be in the set.

The base data structure of a Bloom filter is a Bit Vector. Here's a small one we'll use to demonstrate:







## Murmur
Murmur is a family of good general purpose hashing functions, suitable for non-cryptographic usage. As stated by Austin Appleby, MurmurHash provides the following benefits:

simple (in term of number of generated assembly instructions).
good distribution (passing chi-squared tests for practically all keysets & bucket sizes.
good avalanche behavior (max bias of 0.5%).
good collision resistance (passes Bob Jenkin's frog.c torture-test. No collisions possible for 4-byte keys, no small (1- to 7-bit) differentials).
great performance on Intel/AMD hardware, good tradeoff between hash quality and CPU consumption.
You can certainly use it to hash UUIDs (like any other advanced hashing functions: CityHash, Jenkins, Paul Hsieh's, etc ...). Now, a Redis bitset is limited to 4 GB bits (512 MB). So you need to reduce 128 bits of data (UUID) to 32 bits (hashed value). Whatever the quality of the hashing function, there will be collisions.

Using an engineered hash function like Murmur will maximize the quality of the distribution, and minimize the number of collisions, but it offers no other guarantee.

Here are some links comparing the quality of general purpose hash functions:

http://www.azillionmonkeys.com/qed/hash.html

http://www.strchr.com/hash_functions