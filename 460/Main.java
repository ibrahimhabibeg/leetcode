class Main{
  public static void main(String[] args) {
    LFUCache lfuCache = new LFUCache(2);
    lfuCache.put(1, 1);
    lfuCache.put(2, 2);
    lfuCache.get(1);
    lfuCache.put(3, 3);
    lfuCache.get(2);
    lfuCache.get(3);
    lfuCache.put(4, 4);
    lfuCache.get(1);
    lfuCache.get(3);
    lfuCache.get(4);
  }
}