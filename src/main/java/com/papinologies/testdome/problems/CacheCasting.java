package com.papinologies.testdome.problems;

public class CacheCasting {
    OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
    Cache cache = (Cache) optimizedDiskCache;
}

class Cache {
}

class DiskCache extends Cache {

}

class MemoryCache extends Cache {
}

class OptimizedDiskCache extends DiskCache {
}