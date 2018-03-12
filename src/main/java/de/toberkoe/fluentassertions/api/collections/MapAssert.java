package de.toberkoe.fluentassertions.api.collections;

import de.toberkoe.fluentassertions.api.Assertions;
import de.toberkoe.fluentassertions.api.objects.AbstractObjectAssert;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MapAssert<K, V> extends AbstractObjectAssert<MapAssert<K, V>, Map<K, V>> {

    private final SetAssert<K> keys;
    private final CollectionAssert<V> values;

    public MapAssert(Map<K, V> value) {
        super(value);
        keys = Assertions.assertThat(value == null ? null : value.keySet());
        values = Assertions.assertThat(value == null ? null : value.values());
    }

    public MapAssert<K, V> containsKey(K key) {
        keys.contains(key);
        return instance;
    }

    public MapAssert<K, V> doesNotContainKey(K key) {
        keys.doesNotContain(key);
        return instance;
    }

    public MapAssert<K, V> containsValue(V value) {
        values.contains(value);
        return instance;
    }

    public MapAssert<K, V> doesNotContainValue(V value) {
        values.doesNotContain(value);
        return instance;
    }

    public MapAssert<K, V> contains(Map.Entry<K, V> entry) {
        return contains(entry.getKey(), entry.getValue());
    }

    public MapAssert<K, V> contains(K key, V val) {
        if (value.containsKey(key) && Objects.equals(val, value.get(key))) {
            return instance;
        }
        throw error("Expected to contain <%s, %s>", key, val);
    }

    public MapAssert<K, V> doesNotContain(Map.Entry<K, V> entry) {
        if (!value.containsKey(entry.getKey()) || !Objects.equals(entry.getValue(), value.get(entry.getKey()))) {
            return instance;
        }
        throw error("Expected not to contain %s", entry);
    }

    public MapAssert<K, V> hasSizeOf(int size) {
        if (value.size() == size) {
            return instance;
        }
        throw error("Expected to have size of %s but was %s", size, value.size());
    }

    public MapAssert<K, V> hasKeySizeOf(int size) {
        keys.hasSizeOf(size);
        return instance;
    }

    public MapAssert<K, V> hasValueSizeOf(int size) {
        values.hasSizeOf(size);
        return instance;
    }

    public MapAssert<K, V> hasSameSizeAs(Map<K, V> map) {
        if (value.size() == map.size()) {
            return instance;
        }
        throw error("Expected to have size of %s but was %s", map.size(), value.size());
    }

    public MapAssert<K, V> isEmpty() {
        if (value.isEmpty()) {
            return instance;
        }
        throw error("Expected to be empty but was %s", value);
    }

    public MapAssert<K, V> isNotEmpty() {
        if (!value.isEmpty()) {
            return instance;
        }
        throw error("Expected to be not empty");
    }

    public MapAssert<K, V> isNullOrEmpty() {
        if (test(Objects::isNull, v -> v != null && value.isEmpty())) {
            return instance;
        }
        throw error("Expected to be null or empty");
    }

    @SafeVarargs
    public final MapAssert<K, V> containsOnly(Map.Entry<K, V>... entries) {
        hasSizeOf(entries.length);
        return containsAllOf(entries);
    }

    @SafeVarargs
    public final MapAssert<K, V> containsAllOf(Map.Entry<K, V>... entries) {
        Stream.of(entries).forEach(this::contains);
        return this;
    }

    @SafeVarargs
    public final MapAssert<K, V> containsNoneOf(Map.Entry<K, V>... entries) {
        Stream.of(entries).forEach(this::doesNotContain);
        return this;
    }

    public MapAssert<K, V> doesNotHaveDuplicatedValues() {
        values.doesNotHaveDuplicates();
        return this;
    }
}
