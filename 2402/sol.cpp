#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        sort(meetings.begin(), meetings.end());
        ll time_now = 0;
        vector<int> number_of_uses(n);
        set<int> empty_rooms;
        set<pair<ll, int>> rooms_in_use; // (first_avillable_time, room_number)
        for(int i = 0; i < n; i++) empty_rooms.insert(i);
        for(auto m: meetings) {
            ll meeting_start = m[0], meeting_end = m[1];
            time_now = max(time_now, meeting_start);
            while(!rooms_in_use.empty() && (*rooms_in_use.begin()).first <= time_now) {
                empty_rooms.insert((*rooms_in_use.begin()).second);
                rooms_in_use.erase(rooms_in_use.begin());
            }
            if(empty_rooms.empty()) {
                // Wait for the first one to finish
                ll first_avillable_time = (*rooms_in_use.begin()).first;
                time_now = first_avillable_time;
                // Even if there are more than one with the same first_avillable_time, set will return the one with min room number
                // No need for clearing up with while loop
                empty_rooms.insert((*rooms_in_use.begin()).second);
                rooms_in_use.erase(rooms_in_use.begin());
            }
            int room = *empty_rooms.begin();
            empty_rooms.erase(empty_rooms.begin());
            rooms_in_use.insert(make_pair(time_now + meeting_end - meeting_start, room));
            number_of_uses[room]++;
        }
        int max_used_room = 0;
        for(int i = 0; i < n; i++) if(number_of_uses[i] > number_of_uses[max_used_room]) max_used_room = i;
        return max_used_room;
    }
};