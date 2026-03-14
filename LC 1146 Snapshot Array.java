// LC 1146 Snapshot Array

class SnapshotArray {

    List<int[]>[] arr;
    int snapId = 0;

    public SnapshotArray(int length) {
        arr = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new ArrayList<>();
            arr[i].add(new int[]{0, 0});
        }
    }

    public void set(int index, int val) {
        arr[index].add(new int[]{snapId, val});
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> list = arr[index];
        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid)[0] <= snap_id) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return list.get(r)[1];
        
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
