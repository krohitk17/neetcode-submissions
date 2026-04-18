class Solution {
    Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
    List<String> itinerary = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets)
            ticketMap
                .computeIfAbsent(ticket.get(0), key -> new PriorityQueue<String>())
                .add(ticket.get(1));
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    void dfs(String from) {
        PriorityQueue<String> tickets = ticketMap.get(from);
        while (tickets != null && !tickets.isEmpty())
            dfs(tickets.poll());
        itinerary.add(from);
    }
}
